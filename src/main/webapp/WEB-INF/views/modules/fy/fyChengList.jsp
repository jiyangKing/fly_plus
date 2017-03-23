<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>电子称管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/fy/fyCheng/">电子称列表</a></li>
		<shiro:hasPermission name="fy:fyCheng:edit"><li><a href="${ctx}/fy/fyCheng/form">电子称添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="fyCheng" action="${ctx}/fy/fyCheng/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>ip：</label>
				<form:input path="ip" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>运行状态：</label>
				<form:select path="status" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('fy_cheng_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>是否开：</label>
				<form:radiobuttons path="enable" items="${fns:getDictList('fy_cheng_enable')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>类型：</label>
				<form:select path="type" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('fy_cheng_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>ip</th>
				<th>端口</th>
				<th>部门id</th>
				<th>X坐标</th>
				<th>Y坐标</th>
				<th>楼层</th>
				<th>运行状态</th>
				<th>是否开</th>
				<th>类型</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="fy:fyCheng:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="fyCheng">
			<tr>
				<td><a href="${ctx}/fy/fyCheng/form?id=${fyCheng.id}">
					${fyCheng.ip}
				</a></td>
				<td>
					${fyCheng.port}
				</td>
				<td>
					${fyCheng.depart.name}
				</td>
				<td>
					${fyCheng.locationx}
				</td>
				<td>
					${fyCheng.locationy}
				</td>
				<td>
					${fyCheng.locationz}
				</td>
				<td>
					${fns:getDictLabel(fyCheng.status, 'fy_cheng_status', '')}
				</td>
				<td>
					${fns:getDictLabel(fyCheng.enable, 'fy_cheng_enable', '')}
				</td>
				<td>
					${fns:getDictLabel(fyCheng.type, 'fy_cheng_type', '')}
				</td>
				<td>
					<fmt:formatDate value="${fyCheng.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fyCheng.remarks}
				</td>
				<shiro:hasPermission name="fy:fyCheng:edit"><td>
    				<a href="${ctx}/fy/fyCheng/form?id=${fyCheng.id}">修改</a>
					<a href="${ctx}/fy/fyCheng/delete?id=${fyCheng.id}" onclick="return confirmx('确认要删除该电子称吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>