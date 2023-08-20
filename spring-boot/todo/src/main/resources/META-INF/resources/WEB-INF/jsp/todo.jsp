<%@ include file="common/header.jspf" %> <%@ include
file="common/navigation.jspf" %>

<div class="container">
    <h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input path="description" required="required" />
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate">TargetDate</form:label>
            <form:input path="targetDate" required="required" />
        </fieldset>
        <form:errors path="description" />
        <form:input type="hidden" path="id" required="required" />
        <form:input type="hidden" path="isDone" required="required" />
        <input type="submit" value="Submit" class="btn btn-success" />
    </form:form>
</div>

<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
    $("#targetDate").datepicker({
        format: "yyyy-mm-dd",
        startDate: "-3d",
    });
</script>
