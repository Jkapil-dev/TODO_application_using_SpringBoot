


<%@ include file="common/header.jspf"%>

<title>Add ToDos page</title>

</head>
<body>


	<%@ include file="common/navigation.jspf"%>
	</nav>
	<div class="container">

		<h1>Enter ToDo Details:</h1>
		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description">Description:</form:label>
				<form:input type="text" path="description" required="required" />
				<form:errors path="description" cssClass="text-warning"
					element="div" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">TargetDate:</form:label>
				<form:input type="text" path="targetDate" required="required" />
				<form:errors path="targetDate" cssClass="text-warning" element="div" />
			</fieldset>

			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="done" />
			<br>
			<input type="submit" class="btn btn-success" />
		</form:form>

	</div>
	<%@ include file="common/footer.jspf"%>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd',
			autoclose : true

		});
	</script>