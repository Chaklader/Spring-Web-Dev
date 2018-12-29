package com.vladmihalcea.book.hpjp.hibernate.fetching;

import com.vladmihalcea.book.hpjp.hibernate.forum.Attachment;
import com.vladmihalcea.book.hpjp.hibernate.forum.MediaType;
import com.vladmihalcea.book.hpjp.util.AbstractMySQLIntegrationTest;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

/**
 * @author Vlad Mihalcea
 */
public class LazyAttributeTest extends AbstractMySQLIntegrationTest {

    @Override
    protected Class<?>[] entities() {
        return new Class<?>[] {
            Attachment.class,
        };
    }

    @Override
    protected Properties properties() {
        Properties properties = super.properties();
        //properties.setProperty(AvailableSettings.USE_STREAMS_FOR_BINARY, Boolean.FALSE.toString());
        return properties;
    }

    @Test
    public void test() throws URISyntaxException {
        final Path bookFilePath = Paths.get(Thread.currentThread().getContextClassLoader().getResource("ehcache.xml").toURI());
        final Path videoFilePath = Paths.get(Thread.currentThread().getContextClassLoader().getResource("spy.properties").toURI());

        AtomicReference<Long> bookIdHolder = new AtomicReference<>();
        AtomicReference<Long> videoIdHolder = new AtomicReference<>();

        doInJPA(entityManager -> {
            try {
                Attachment book = new Attachment();
                book.setName("High-Performance Java Persistence");
                book.setMediaType(MediaType.PDF);
                book.setContent(Files.readAllBytes(bookFilePath));
                entityManager.persist(book);

                Attachment video = new Attachment();
                video.setName("High-Performance Hibernate");
                video.setMediaType(MediaType.MPEG_VIDEO);
                video.setContent(Files.readAllBytes(videoFilePath));
                entityManager.persist(video);

                bookIdHolder.set(book.getId());
                videoIdHolder.set(video.getId());
            } catch (IOException e) {
                fail(e.getMessage());
            }
        });

        doInJPA(entityManager -> {
            try {
                Long bookId = bookIdHolder.get();
                Long videoId = videoIdHolder.get();

                Attachment book = entityManager.find(Attachment.class, bookId);
                LOGGER.debug("Fetched book: {}", book.getName());
                assertArrayEquals(Files.readAllBytes(bookFilePath), book.getContent());

                Attachment video = entityManager.find(Attachment.class, videoId);
                LOGGER.debug("Fetched video: {}", video.getName());
                assertArrayEquals(Files.readAllBytes(videoFilePath), video.getContent());
            } catch (IOException e) {
                fail(e.getMessage());
            }
        });
    }
}
