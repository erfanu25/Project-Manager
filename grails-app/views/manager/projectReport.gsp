<meta name="layout" content="managerProgress"/>
<script>
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            animationEnabled: true,
            title:{
                text: "Daily Work Progress"
            },
            axisX: {
                valueFormatString: "DD MMM,YY"
            },
            axisY: {
                title: "Task",
                includeZero: false,
                suffix: " "
            },
            legend:{
                cursor: "pointer",
                fontSize: 16,
                itemclick: toggleDataSeries
            },
            toolTip:{
                shared: true
            },
            data: [{
                name: "Myrtle Beach",
                type: "spline",
                yValueFormatString: "#0.## °C",
                showInLegend: true,
                dataPoints: [
                    { x: new Date(2017,6,24), y: 31 },
                    { x: new Date(2017,6,25), y: 31 },
                    { x: new Date(2017,6,26), y: 29 },
                    { x: new Date(2017,6,27), y: 29 },
                    { x: new Date(2017,6,28), y: 31 },
                    { x: new Date(2017,6,29), y: 30 },
                    { x: new Date(2017,6,30), y: 29 }
                ]
            },
                {
                    name: "Martha Vineyard",
                    type: "spline",
                    yValueFormatString: "#0.## °C",
                    showInLegend: true,
                    dataPoints: [
                        { x: new Date(2017,6,24), y: 20 },
                        { x: new Date(2017,6,25), y: 20 },
                        { x: new Date(2017,6,26), y: 25 },
                        { x: new Date(2017,6,27), y: 25 },
                        { x: new Date(2017,6,28), y: 25 },
                        { x: new Date(2017,6,29), y: 25 },
                        { x: new Date(2017,6,30), y: 25 }
                    ]
                },
                {
                    name: "Nantucket",
                    type: "spline",
                    yValueFormatString: "#0.## °C",
                    showInLegend: true,
                    dataPoints: [
                        { x: new Date(2017,6,24), y: 22 },
                        { x: new Date(2017,6,25), y: 19 },
                        { x: new Date(2017,6,26), y: 23 },
                        { x: new Date(2017,6,27), y: 24 },
                        { x: new Date(2017,6,28), y: 24 },
                        { x: new Date(2017,6,29), y: 23 },
                        { x: new Date(2017,6,30), y: 23 }
                    ]
                }]
        });
        chart.render();

        function toggleDataSeries(e){
            if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                e.dataSeries.visible = false;
            }
            else{
                e.dataSeries.visible = true;
            }
            chart.render();
        }

    }
</script>


<div class="card">
    <div class="card-header bg-info text-white">
        <g:message code="Daily Work Progress"/>
        <span class="float-right">
            <div class="btn-group">
            </div>
        </span>
    </div>

    <div class="card-body">
        <div style="width: 600px">
            <div id="chartContainer" style="height: 370px; width: 100%;"></div>
        </div>

    </div>
</div>