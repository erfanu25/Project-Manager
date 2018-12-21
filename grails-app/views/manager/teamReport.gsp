<meta name="layout" content="managerProgress"/>

<script>
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            exportEnabled: true,
            animationEnabled: true,
            title:{
                text: "Task Progress of Members"
            },
            subtitles: [{
                text: " "
            }],
            axisX: {
                title: " "
            },
            axisY: {
                title: "Completed Task",
                titleFontColor: "#4F81BC",
                lineColor: "#4F81BC",
                labelFontColor: "#4F81BC",
                tickColor: "#4F81BC"
            },
            axisY2: {
                title: "Assigned Task",
                titleFontColor: "#C0504E",
                lineColor: "#C0504E",
                labelFontColor: "#C0504E",
                tickColor: "#C0504E"
            },
            toolTip: {
                shared: true
            },
            legend: {
                cursor: "pointer",
                itemclick: toggleDataSeries
            },
            data: [{
                type: "column",
                name: "Completed Task",
                showInLegend: true,
                yValueFormatString: "#,##0.# ",
                dataPoints: [

                    <g:each in="${taskDone}" var="it" >
                    { label: "${it.name}", y: ${it.dailyTask.size()} },
                    </g:each>
                ]
            },
                {
                    type: "column",
                    name: "Assigned Task",
                    axisYType: "secondary",
                    showInLegend: true,
                    yValueFormatString: "#,##0.# ",
                    dataPoints: [
                        <g:each in="${taskDone}" var="it" >
                        { label: "${it.name}", y: ${it.task.size()} },
                        </g:each>
                    ]
                }]
        });
        chart.render();

        function toggleDataSeries(e) {
            if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                e.dataSeries.visible = false;
            } else {
                e.dataSeries.visible = true;
            }
            e.chart.render();
        }

    }
</script>



<div class="card">
    <div class="card-header bg-info text-white">
        <g:message code="Task Progress Report"/>
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