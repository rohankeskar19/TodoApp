const table = document.getElementById("table");
const tableBody = document.getElementById("table-body");
const addTodoButton = document.getElementById("add-todo-button");
const addTodoDialog = document.getElementById("dialog");
const closeModal = document.getElementById("close-modal");
const closeModalCross = document.getElementById("close-modal-cross");
const addTodoModal = document.getElementById("add-todo-modal");

const todoContent = document.getElementById("content");
const dueDate = document.getElementById("due-date");



const addTodo = (todo,date) => {
	const options = {
			method: 'POST',
			body: JSON.stringify({
				todo,
				date
			})
	}
	fetch("/TodoApp/AddTodo",options)
	.then(res => {
		
		console.log(res);
		
		
	})
	
}

addTodoButton.addEventListener("click",() => {
	addTodoDialog.style.display = "block";
	
	
});


closeModal.addEventListener("click",() => {
	addTodoDialog.style.display = "none";
})


closeModalCross.addEventListener("click",() => {
	addTodoDialog.style.display = "none";
})


addTodoModal.addEventListener("click",() => {
	const todo = todoContent.value;
	const dateInput = dueDate.value;
	
	var date = new Date(dateInput);
	
	addTodo(todo,date);
})





