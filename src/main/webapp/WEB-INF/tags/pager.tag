<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="page" type="com.ds.domain.Page" required="true"%>
<%@ attribute name="types" type="java.util.Map" required="true"%>

<div class="list-group">
	<c:forEach items="${page.data }" var="item">

		<div class="list-group-item">
			<div class="row">
				<div class="col-md-10 col-sm-10">
					<img src="<c:url value="/static/image/1.jpg"></c:url>" alt=""
						class="img-rounded header-icon"> <span class="label-green">${types[item.type]}</span>
					<a href="<c:url value="/post/show/${item.postId}"></c:url>"
						class="topic-title"> ${item.title} </a>
				</div>
				<div class="col-md-2 col-sm-2 text-right">
					<img src="<c:url value="/static/image/1.jpg"></c:url>" alt=""
						class="img-rounded header-icon-small">
					<div class="reply-time">${item.publishTime}</div>
				</div>

			</div>

		</div>
	</c:forEach>
</div>
<ul class="pagination">
	<c:choose>
		<c:when test="${page.currentPageNo == 1 }">
			<li class="disabled"><a >&laquo;</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="<c:url value="/?page=${page.currentPageNo -1 }&type=${currentType.name}" />">&laquo;</a></li>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${page.currentPageNo <= 3 }">
			<c:choose>
				<c:when test="${ page.totalPageCount>5}">
					<c:forEach begin="1" end="5" step="1" var="pageNumber">
						<li
							<c:if test="${pageNumber==page.currentPageNo }">class="active"</c:if>><a
							href="<c:url value="/?page=${ pageNumber}&type=${currentType.name}" />">${pageNumber}</a></li>
					</c:forEach>
					<li><a>...</a></li>
				</c:when>
				<c:otherwise>
					<c:forEach begin="1" end="${page.totalPageCount }" step="1"
						var="pageNumber">
						<li
							<c:if test="${pageNumber==page.currentPageNo }">class="active"</c:if>><a
							href="<c:url value="/?page=${ pageNumber}&type=${currentType.name}" />">${pageNumber}</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${page.currentPageNo > 3 }">
			<c:choose>
				<c:when test="${ page.totalPageCount<=5}">
					<c:forEach begin="1" end="${ page.totalPageCount}" step="1" 
						var="pageNumber">
						<li
							<c:if test="${pageNumber==page.currentPageNo }">class="active"</c:if>><a
							href='<c:url value="/?page=${ pageNumber}&type=${currentType.name}" />'>${pageNumber}</a></li>
					</c:forEach>

				</c:when>
				<c:when test="${ page.currentPageNo >= page.totalPageCount -2}">
					<li><a>...</a></li>
					<c:forEach begin="${ page.totalPageCount -4}"
						end="${ page.totalPageCount}" step="1" var="pageNumber">
						<li
							<c:if test="${pageNumber==page.currentPageNo }">class="active"</c:if>><a
							href="<c:url value="/?page=${ pageNumber}&type=${currentType.name}" />">${pageNumber}</a></li>
					</c:forEach>

				</c:when>
				<c:otherwise>
					<li><a>...</a></li>
					<c:forEach begin="${page.currentPageNo-2}"
						end="${page.currentPageNo+2}" step="1" var="pageNumber">
						<li
							<c:if test="${pageNumber==page.currentPageNo }">class="active"</c:if>><a
							href="#">${pageNumber}</a></li>
					</c:forEach>
					<li><a>...</a></li>
				</c:otherwise>
			</c:choose>
		</c:when>



	</c:choose>
	<c:choose>
		<c:when test="${page.currentPageNo == page.totalPageCount }">
			<li class="disabled"><a>&raquo;</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="<c:url value="/?page=${page.currentPageNo +1 }&type=${currentType.name}" />">&raquo;</a></li>
		</c:otherwise>
	</c:choose>

</ul>




