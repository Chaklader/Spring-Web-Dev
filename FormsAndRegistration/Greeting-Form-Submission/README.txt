SPRING BOOT, JSP GETTING STARTED BOOTSTRAP



org.apache.jasper.JasperException: An exception occurred processing JSP page [/WEB-INF/jsp/index.jsp] at line [43]

40:         <div class="form-group ${status.error ? 'has-error' : ''}">
41:             <label class="col-sm-2 control-label">Title</label>
42:             <div class="col-sm-10">
43:                 <form:input path="title" type="text" class="form-control " id="title" placeholder="title"/>
44:                 <form:errors path="title" class="control-label"/>
45:             </div>
46:         </div>