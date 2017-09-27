var whereToGo = jQuery("#whereToGo");
var leaveTime = jQuery("#leaveTime");
var backTime = jQuery("#backTime");

function changeStatus() {
    if (whereToGo.val() === "STAY_IN_SCHOOL") {
        leaveTime.prop("disabled", true);
        backTime.prop("disabled", true);
    } else {
        leaveTime.prop("disabled", false);
        backTime.prop("disabled", false);
    }
    return changeStatus;
}

whereToGo.change(changeStatus());
