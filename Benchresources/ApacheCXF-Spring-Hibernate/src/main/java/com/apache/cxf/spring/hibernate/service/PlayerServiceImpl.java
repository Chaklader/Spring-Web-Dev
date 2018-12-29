package com.apache.cxf.spring.hibernate.service;

import java.util.List;

import in.benchresources.cdm.player.PlayerListType;
import in.benchresources.cdm.player.PlayerType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apache.cxf.spring.hibernate.model.Player;

@Service("playerService")
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * returns a String value with SUCCESS message after adding a player
	 */
	@Transactional
	@Override
	public String createOrSaveNewPLayerInfo(PlayerType playerType) {

		// get player information from formal arguments
		Player newPlayer = new Player();
		newPlayer.setName(playerType.getName());
		newPlayer.setAge(playerType.getAge());
		newPlayer.setMatches(playerType.getMatches());

		// inserts into database & return playerId (primary_key)
		int playerId = (Integer) sessionFactory.getCurrentSession().save(newPlayer);
		return "Player information saved successfully with PLAYER_ID " + playerId;
	}

	/**
	 * retrieves a player object based on the playerId supplied in the formal argument using @PathParam
	 */
	@Transactional
	@Override
	public PlayerType getPlayerInfo(int playerId) {

		// retrieve player based on the id supplied in the formal argument
		Player player = (Player) sessionFactory.getCurrentSession().get(Player.class, playerId);

		// set values and return
		PlayerType getplayer = new PlayerType	();
		getplayer.setPlayerId(player.getPlayerId());
		getplayer.setName(player.getName());
		getplayer.setAge(player.getAge());
		getplayer.setMatches(player.getMatches());
		return getplayer;
	}

	/**
	 * returns a String value with SUCCESS message after updating a player
	 */
	@Transactional
	@Override
	public String updatePlayerInfo(PlayerType playerType) {

		// update player info & return SUCCESS message
		Player updatePlayer = new Player();
		updatePlayer.setPlayerId(playerType.getPlayerId());
		updatePlayer.setName(playerType.getName());
		updatePlayer.setAge(playerType.getAge());
		updatePlayer.setMatches(playerType.getMatches());

		// update database with player information and return success msg
		sessionFactory.getCurrentSession().update(updatePlayer);
		return "Player information updated successfully";
	}

	/**
	 * returns a String value with SUCCESS message after deleting a player
	 */
	@Transactional
	@Override
	public String deletePlayerInfo(PlayerType playerType) {

		// delete player info & return SUCCESS message
		Player deletePlayer = new Player();
		deletePlayer.setPlayerId(playerType.getPlayerId());
		deletePlayer.setName(playerType.getName());
		deletePlayer.setAge(playerType.getAge());
		deletePlayer.setMatches(playerType.getMatches());

		// delete player information and return success msg
		sessionFactory.getCurrentSession().delete(deletePlayer);
		return "Player information deleted successfully";
	}

	/**
	 * retrieves all players stored
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public PlayerListType getAllPlayerInfo() {

		// get all player info from database
		List<Player> lstPlayer = sessionFactory.getCurrentSession().createCriteria(Player.class).list();

		// create a object of type PlayerType which takes player objects in its list
		PlayerListType playerListType = new PlayerListType();

		// iterate and set the values and return list
		for(Player player : lstPlayer) {
			// add player info
			PlayerType playerType = new PlayerType();
			playerType.setPlayerId(player.getPlayerId());
			playerType.setName(player.getName());
			playerType.setAge(player.getAge());
			playerType.setMatches(player.getMatches());
			playerListType.getPlayerType().add(playerType); // add to playerListType
		}
		return playerListType;
	}
}