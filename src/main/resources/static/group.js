document.addEventListener('DOMContentLoaded', function(){
    document.getElementById("addGroupButton").addEventListener("click", function(){
        let newGroupName = document.getElementById("newGroupName").value;
        $.ajax({
            type: "POST",
            url: "/addGroup",
            data: { name: newGroupName }
        });
    });
});