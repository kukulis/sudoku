/**
 * 
 */
var fillBoardsListInner=function(data) {
	console.log("fillBoardsList called" );
	var table=document.createElement("table");
	table.className="table table-bordered";
	
//	var output = document.querySelector("#people tbody");
	data.forEach(function(board) {
	  var row = document.createElement("tr");
	 
	  ["id"].forEach(function(prop) {
	    var td = document.createElement("td");
	    td.appendChild(document.createTextNode(board[prop]));
	    row.appendChild(td);
	  });
	  var anchor=document.createElement("a");
	  anchor.setAttribute("href", "view?id="+board["id"]);
	  anchor.appendChild(document.createTextNode("view board"));
	  var anchorTd=document.createElement("td");
	  anchorTd.appendChild(anchor);
	  row.appendChild(anchorTd);
	 
	  table.appendChild(row);
	});
	
//	var tableDiv=document.querySelector("#boardsList");
//	tableDiv.appendChild( table );
	$("#boardsList").html(table);
}

var fillBoardsList=function (root) {
	
	$.ajax({
		type : "GET",
//		contentType : "application/json",
		url : root+"rest/list",
		// data : JSON.stringify(search),
		// dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			//display(data);
			//enableSearchButton(true);
			fillBoardsListInner ( data );
		},
		error : function(e) {
			console.log("ERROR: ", e);
			//display(e);
			//enableSearchButton(true);
		},
		done : function(e) {
			console.log("DONE");
			//enableSearchButton(true);
		}
	});
}

var createNew=function(root) {
	$.ajax({
		type : "PUT",
//		contentType : "application/json",
		url : root+"rest/new",
		// data : JSON.stringify(search),
		// dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			fillBoardsList(root);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			//display(e);
			//enableSearchButton(true);
		},
		done : function(e) {
			console.log("DONE");
			//enableSearchButton(true);
		}
	});
}