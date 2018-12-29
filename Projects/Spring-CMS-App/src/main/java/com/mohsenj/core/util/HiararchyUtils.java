package com.mohsenj.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mohsenj.module.menu.model.Menu;

/**
 * Description of Hierarchy
 *
 * @author Mohsen Jahanshahi
 */
@Component
public class HiararchyUtils {

	private Map<Integer, Hierarchically> items = new HashMap<Integer, Hierarchically>();
    private Map<Integer, List<Integer>> parents = new HashMap<Integer, List<Integer>>();
    
    /**
     * return all childs and parents id that are child of $id
     * @param type $id
     */
  /*  public ArrayList getAllChilds(int[] cats, int id) {
        $newData = seperateParentsIntoAssoc(cats);


        ArrayList ids = ArrayList();
        ids.add(id)

        getChilds($newData, $id, $ids);

        return ids;
    }
*/
    public String getHForSelect(List<? extends Hierarchically> cats, Integer selected_id, Integer parent) {
        return getHForSelect(cats, selected_id, parent, new ArrayList<Integer>());
    }
    /**
     * H mean hiararchy array data
     * @param array $cats
     * @param type $selected_id
     * @return type
     */
    public String getHForSelect(List<? extends Hierarchically> cats, Integer selected_id, Integer parent, List<Integer> exclude) {

        //$data = $this->createHierarchyList(array($cats));
        seperateParentsIntoAssoc(cats);
        //create appropriate html
        //var_dump($newData);die;

     /*   HashMap hm = new HashMap();
        
        hm.put("raw", cats);
        hm.put("opts", createSelectinput(parent, selected_id, exclude));
        return hm;*/
        
        return createSelectinput(parent, selected_id, exclude, 0);
        
    }
    
    private void seperateParentsIntoAssoc(List<? extends Hierarchically> data) {

        
      //  Map<Integer, Hierarchically> items = new HashMap<Integer, Hierarchically>();
     //   Map<Integer, List<Integer>> parents = new HashMap<Integer, List<Integer>>();
    	
    	// first clear variables
    	items = new HashMap<Integer, Hierarchically>();
        parents = new HashMap<Integer, List<Integer>>();

        if(data == null) {
        	return;
        }
        
        for(Hierarchically item : data) {
        	// items
        	items.put(item.getId(), item);
          
        	// parents variable
        	if(parents.containsKey(item.getParentId())) {
        		List<Integer> tempItem = parents.get(item.getParentId());
        		tempItem.add(item.getId());
        		parents.put(item.getParentId(), tempItem);
        	}
        	else {
        		List<Integer> tempList = new ArrayList<Integer>();
        		tempList.add(item.getId());
        		parents.put(item.getParentId(), tempList);
        	}
          
        }
      //  System.out.println(data);
       // System.out.println(parents);
       // System.out.println(items);

     //   Map<String, ?> newData = new HashMap<String, ?>();
    //    newData.put("items", items);
      //  newData.put("parents", parents);
      //  return newData;
    }

    private String createSelectinput(Integer parent, Integer editId, List<Integer> exclude, Integer level) {
    	level++;
        String html = "";

        if(parents.containsKey(parent)) {
            for(Integer itemId : parents.get(parent)) {

                if (exclude.contains(itemId)) {
                        continue;
                }

                // check if item selected (for edit mode)
                String selected = "";
                if(editId != null && editId != 0 && items.get(itemId).getId() == editId){
                  selected +=  " selected=\"selected\"";
                }

            //    if (parents.containsKey(itemId)) {
                  html += "<option value=\"" + items.get(itemId).getId() + "\" style=\"font-weight: bold;\"" + selected + "> ";
                  // child intended
                  for(int l=1; l<level; l++){
                      html += " -"; 
                   }
                  
                  
                  html += " " + items.get(itemId).getTitle() + "</option>";
                  
                  if (parents.containsKey(itemId)) {
                	  html += createSelectinput(itemId, editId, exclude, level);
                     
                  }
           //     }
            /*    else { // item has no child
                  

                	html += "<option value=\"" + items.get(itemId).getId() + "\" style=\"margin-right:8px\""+selected+">" + items.get(itemId).getTitle() + " </option>";


                }*/
                  
            }
        }
        
        return html;
    }
    
    public String getHForTableMenu(List<? extends Hierarchically> menus, Integer parentId) {
    	
    	seperateParentsIntoAssoc(menus);
        return createTableTrMenu(parentId, 0);
	}
    
	public String getHForTableMenu(List<? extends Hierarchically> menus) {

        return getHForTableMenu(menus, null);
	}
	
	public String createTableTrMenu(Integer parent, Integer level) {
		level++;
        String html = "";

        if(parents.containsKey(parent)) {
            for(Integer itemId : parents.get(parent)) {

            	html += "<tr class=\"level-"+level+"\">";
            	html += "<td>";
            	for(int l=1; l<level; l++){
                    html += "-"; 
                 }
            	html  += " " + items.get(itemId).getTitle() + "</td>";
            	
            	String link = ServletUriComponentsBuilder.fromCurrentContextPath().path("/admin/menu/edit/"+items.get(itemId).getId()).build().toUriString();
            	html += "<td>" +
            			"<a class=\"btn btn-mini btn-info\" href=\"" + link+ "\" ><i class=\"icon-pencil\"></i> edit</span></a>"
            			+ " <a class=\"btn btn-mini btn-danger\" onclick=\"post_func(\'" + items.get(itemId).getId() + "\');\" ><i class=\"icon-trash\"></i> delete</span></a>"
            			+ "</td>";
            	
            	html += "</tr>";
       
                  
                  
                  
                  if (parents.containsKey(itemId)) {
                	  html += createTableTrMenu(itemId, level);
                     
                  }
                  
            }
        }
        
        return html;
		
	}
	
	public String getMainMenu(List<? extends Hierarchically> cats, Integer selected_id, Integer parent) {
        seperateParentsIntoAssoc(cats);

        return createMainMenu(parent, selected_id, 0);
    }
	
	private String createMainMenu(Integer parent, Integer editId, Integer level) {
    	level++;
        String html = "";

        if(parents.containsKey(parent)) {
            for(Integer itemId : parents.get(parent)) {


                // check if item selected (for edit mode)
                String selected = "";
                if(editId != null && editId != 0 && items.get(itemId).getId() == editId){
                  selected +=  " active ";
                }

                  Menu menu = (Menu)items.get(itemId);
                  
                  if (parents.containsKey(itemId)) {
                	  
                	  if(level != 0) {
                		  html += "<li class=\"dropdown "+selected+"\">";
                    	  html += "<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" >"+menu.getTitle()+" <i class=\"icon-angle-down\"></i></a>";
                    	  html += "<ul class=\"dropdown-menu\">";
                	  }
                	  
                	  //
                	  html += createMainMenu(itemId, editId, level);
                	
                	  if(level != 0) {
	                	  html += "</ul>";
	                	  html += "</li>";
                	  }
                  }
                  else { // if has no child
                	  html += "<li class=\" "+selected+"\">";

                  	  String link = ServletUriComponentsBuilder.fromCurrentContextPath().path(menu.getLink()).build().toUriString();
                	  html += "<a href=\""+link+"\" >"+menu.getTitle()+"</a>";

               // 	  html += "<a href=\""+menu.getLink()+"\" >"+menu.getTitle()+"</a>";
                	  
                	  html += "</li>";
                  }
                  
                  
            }
        }
        
        return html;
    }
	

}
