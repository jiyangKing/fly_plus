<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存记录称重管理</title>
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
		<li class="active"><a href="${ctx}/fy/fyGarbageList/">保存记录称重列表</a></li>
		<shiro:hasPermission name="fy:fyGarbageList:edit"><li><a href="${ctx}/fy/fyGarbageList/form">保存记录称重添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="fyGarbageList" action="${ctx}/fy/fyGarbageList/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>收集人：</label>
				<sys:treeselect id="shouer" name="shouer.id" value="${fyGarbageList.shouer.id}" labelName="" labelValue="${fyGarbageList.shouer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>负责人：</label>
				<sys:treeselect id="departer" name="departer.id" value="${fyGarbageList.departer.id}" labelName="" labelValue="${fyGarbageList.departer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>科室：</label>
				<sys:treeselect id="office" name="office.id" value="${fyGarbageList.office.id}" labelName="" labelValue="${fyGarbageList.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>垃圾类型：</label>
				<form:select path="type" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('fy_garbage_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>状态：</label>
				<form:select path="status" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('fy_garbage_status_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>条码号：</label>
				<form:input path="tiaoMaUuid" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>条码编号</th>
				<th>条码信息</th>
				<th>重量(Kg)</th>
				<th>状态</th>
				<th>是否抽检</th>
				<th>收集人</th>
				<th>负责人</th>
				<th>科室</th>
				<th>垃圾类型</th>
				<th>加入日期</th>
				<th>允许误差(Kg)</th>
				<th>抽检重量(Kg)</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="fy:fyGarbageList:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="fyGarbageList">
			<tr>
				<td>
					<a href="${ctx}/fy/fyGarbageList/form?id=${fyGarbageList.id}">
						${fyGarbageList.tiaoMaUuid}
					</a>
				</td>
				<td>
						${fyGarbageList.tiaoMaInfo}
				</td>
				<td>
					${fyGarbageList.weight/1000.0}
				</td>
				<td>
						${fns:getDictLabel(fyGarbageList.status, 'fy_garbage_status_type', '')}
				</td>
				<td>
					${fns:getDictLabel(fyGarbageList.choujianFlag, 'fy_choujian_type', '')}
				</td>
				<td>
					${fyGarbageList.shouer.name}
				</td>
				<td>
					${fyGarbageList.departer.name}
				</td>
				<td>
					${fyGarbageList.office.name}
				</td>
				<td>
					${fns:getDictLabel(fyGarbageList.type, 'fy_garbage_type', '')}
				</td>
				<td>
					<fmt:formatDate value="${fyGarbageList.inDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fyGarbageList.wuCha/1000.0}
				</td>
				<td>
					${fyGarbageList.weightChoujian==null?'':fyGarbageList.weightChoujian/1000.0}
				</td>

				<td>
					<fmt:formatDate value="${fyGarbageList.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fyGarbageList.remarks}
				</td>
				<shiro:hasPermission name="fy:fyGarbageList:edit"><td>
    				<a href="${ctx}/fy/fyGarbageList/form?id=${fyGarbageList.id}">修改</a>
					<a href="${ctx}/fy/fyGarbageList/delete?id=${fyGarbageList.id}" onclick="return confirmx('确认要删除该保存记录称重吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>