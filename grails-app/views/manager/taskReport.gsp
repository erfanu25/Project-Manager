<meta name="layout" content="managerProgress"/>


<script>
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            exportEnabled: true,
            animationEnabled: true,
            title:{
                text: "Completed Task Report"
            },
            legend:{
                cursor: "pointer",
                itemclick: explodePie
            },
            data: [{
                type: "pie",
                showInLegend: true,
                toolTipContent: "{name}: <strong>{y}</strong>",
                indexLabel: "{name} - {y} Task",
                dataPoints: [
                    <g:each in="${taskDone}" var="it" >
                    { y: "${it.dailyTask.size()}", name: "${it.name}", exploded: true  },
                    </g:each>
                ]
            }]
        });
        chart.render();
    }

    function explodePie (e) {
        if(typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) === "undefined" || !e.dataSeries.dataPoints[e.dataPointIndex].exploded) {
            e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
        } else {
            e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
        }
        e.chart.render();

    }
</script>

<div class="card">
    <div class="card-header bg-info text-white">
        <g:message code="Completed Task Report"/>
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