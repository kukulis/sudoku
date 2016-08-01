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

var fillBoardsList=function () {
	var data=[ {id:1},  {id:2}, {id:3} ];
	fillBoardsListInner ( data );
}