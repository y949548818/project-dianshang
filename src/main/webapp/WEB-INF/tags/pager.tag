<%@ tag language="java" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="page" type="com.ds.domain.Page" required="true" %>  
<div class="col-md-9 col-sm-9 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">

                        <button type="button" class="btn btn-link">
                            按钮1
                        </button>
                        <button type="button" class="btn btn-link">
                            按钮1
                        </button>
                        <button type="button" class="btn btn-link">
                            按钮1
                        </button>                                                        

                    </div>
                    <div class="panel-body">
	                    <div class="list-group">
	                    	<c:forEach items="${page.data }" var="item" > 
		                        
		                        <div class="list-group-item">
		                            <div class="row">
		                                <div class="col-md-10 col-sm-10">
		                                    <img src="<c:url value="/static/image/1.jpg"></c:url>" alt="" class="img-rounded header-icon">
		                                    <span class="label-green">测试</span>
		                                    <a href="<c:url value="/post/show/${item.postId}"></c:url>" class="topic-title">
		                                        ${item.title}
		                                    </a>
		                                </div>
		                                <div class="col-md-2 col-sm-2 text-right">
		                                    <img src="<c:url value="/static/image/1.jpg"></c:url>" alt="" class="img-rounded header-icon-small">
		                                    <div class="reply-time">
		                                        1小时前
		                                    </div>
		                                </div>
		
		                           </div>
		                           
		                        </div>
	                        </c:forEach>
	                    </div>
                    </div>
                    <div class="panel-footer">
	                    <ul class="pagination">
						  <li><a href="#">&laquo;</a></li>
						  <c:choose>
						  	<c:when test="${page.currentPageNo <= 3 }"> 
								<c:choose>
						  			<c:when test="${ page.totalPageCount>5}">
										<c:forEach begin="1" end="5" step="1" var="pageNumber">
								  			<li <c:if test="${pageNumber==page.currentPageNo }">class="active"</c:if>><a href="#"  >${pageNumber}</a></li>
								  		</c:forEach>
								  		<li><a  >...</a></li>
						  			</c:when>
						  			<c:otherwise>
										<c:forEach begin="1" end="${page.totalPageCount }" step="1" var="pageNumber">
								  			<li <c:if test="${pageNumber==page.currentPageNo }">class="active"</c:if>><a href="#"  >${pageNumber}</a></li>
								  		</c:forEach>						  			
						  			</c:otherwise>
						  		</c:choose>
						  	</c:when>
						  	<c:when test="${page.currentPageNo > 3 }">
								<c:choose>
						  			<c:when test="${ page.totalPageCount<=5}">
										<c:forEach begin="1" end="${ page.totalPageCount}" step="1" var="pageNumber">
								  			<li <c:if test="${pageNumber==page.currentPageNo }">class="active"</c:if>><a href="#"  >${pageNumber}</a></li>
								  		</c:forEach>
								  		
						  			</c:when>
						  			<c:when test="${ page.currentPageNo >= page.totalPageCount -2}">
						  				<li><a  >...</a></li>
											<c:forEach begin="${ page.totalPageCount -4}" end="${ page.totalPageCount}" step="1" var="pageNumber">
									  			<li <c:if test="${pageNumber==page.currentPageNo }">class="active"</c:if>><a href="#"  >${pageNumber}</a></li>
									  		</c:forEach>
								  		
						  			</c:when>
						  			<c:otherwise>
						  				<li><a  >...</a></li>
											<c:forEach begin="${page.currentPageNo-2}" end="${page.currentPageNo+2}" step="1" var="pageNumber">
									  			<li <c:if test="${pageNumber==page.currentPageNo }">class="active"</c:if>><a href="#"  >${pageNumber}</a></li>
									  		</c:forEach>		
								  		<li><a  >...</a></li>				  			
						  			</c:otherwise>
						  		</c:choose>
						  	</c:when>
						  	
						  	
						  
						  </c:choose>
						  <%-- <li><a href="#">${page.currentPageNo}</a></li>
						  <li><a href="#">${page.totalPageCount }</a></li>
						  <li><a href="#">1</a></li>
						  <li><a href="#">2</a></li>
						  <li><a href="#">3</a></li>
						  <li><a href="#">4</a></li>
						  <li><a href="#">5</a></li> --%>

						  
						  <li><a href="#">&raquo;</a></li>
						</ul>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        个人信息
                    </div>
                    <div class="panel-body">
                        
                    </div>
                </div>
                <div class="panel panel-default">
                    
                    <div class="panel-body">
                        <a href="/post/create" type="button" class="btn btn-primary">
                            发布帖子
                        </a>
                    </div>
                </div>
            </div>


