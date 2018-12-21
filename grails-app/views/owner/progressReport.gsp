<meta name="layout" content="progress"/>
<script>
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            exportEnabled: true,
            animationEnabled: true,
            title:{
                text: "Project Progress"
            },
            legend:{
                cursor: "pointer",
                itemclick: explodePie
            },
            data: [{
                type: "pie",
                showInLegend: true,
                toolTipContent: "{name}: <strong></strong>",
                indexLabel: "{name} ",
                dataPoints: [

                    <g:each in="${project}" var="it" >
                    { y: ${it.users.dailyTask.size()+5}, name: "${it.name}", exploded: true },
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
        <g:message code="Project Progress"/>
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