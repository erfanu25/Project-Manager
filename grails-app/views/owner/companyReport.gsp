<meta name="layout" content="progress"/>

<script>
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            animationEnabled: true,
            theme: "light2", // "light1", "light2", "dark1", "dark2"
            title:{
                text: "Company Information"
            },
            axisY: {
                title: "Total"
            },
            data: [{
                type: "column",
                showInLegend: true,
                legendMarkerColor: "grey",
                legendText: " ",
                dataPoints: [
                    { y: ${projectCount}, label: "Projects" },
                    { y: ${manager},  label: "Manager" },
                    { y: ${employee},  label: "Employee" },
                ]
            }]
        });
        chart.render();

    }
</script>

<div class="card">
    <div class="card-header">
        <g:message code="Company Info in a Bar Chart"/>
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