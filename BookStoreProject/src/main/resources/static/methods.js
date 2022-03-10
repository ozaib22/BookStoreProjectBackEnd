
function showRecord (name1, Price, PublishDate) {
let refRow = document.createElement("tr")
let refTd1 = document.createElement("td")
let refTd2 = document.createElement("td")
let refTd3 = document.createElement("td")

refTd1.innerHtml = name1
refTd2.innerHtml = Price
refTd3.innerHtml = PublishDate

refRow.appendChild(refTd1);
refRow.appendChild(refTd2);
refRow.appendChild(refTd3);

refTable.appendChild(refRow)
document.body.appendChild(refTable)

}


function getAll() {
    fetch(`http://localhost:8080/getAll/`)
    .then((response) => {
        if (response.status !== 200) {
            console.log(`getAll does not Worker.status code: ${response.status}`);
            return;
        }

        response.json()
        .then(res => {
            console.log(res);

            refTable = document.createElement("table");
            refTable.classList.add("table","table-primary");

            for (let i= 0; i < res.length; i++) {
                showRecord(res[i].name, res[i].price, res[i].publish_date)
            }
        }) 
        .catch(err => console.error(`Fetch Error :-S ${err}`));

})}


function get() {
    let BookID = document.getElementByID("BookID").value
    fetch('http://localhost:8080/get/' +BookID).then((response) => {
        if (response.status !== 200) {
            console.log('Looks like there was an error) ${Response.status}');}
            return;
            response.json()
            .then(data => {
                close.log(data);

                refTable = document.createElement(table);
                refTable.border = 1
                refTable.classList.add(table);
                showRecord(data.Name,data.Price,data.PublishDate)


            })
            .catch(err => console.error('Fetch Error :-S ${err}'));





    })
}
