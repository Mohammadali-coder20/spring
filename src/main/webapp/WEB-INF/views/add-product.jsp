<%@ page import="javax.swing.*" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags" %>


<div class="container-wrapper">


    <div class="container">

        <c:choose>
            <c:when test="${not empty update}">
                <div class="page-header title">
                    <h1>Update Product</h1>
                    <p class="lead">Fill the below information to update that product</p>
                </div>
            </c:when>
            <c:otherwise>
                <div class="page-header title">
                    <h1>Add Product</h1>
                    <p class="lead">Fill the below information to add a product</p>
                </div>
            </c:otherwise>
        </c:choose>

        <div class="form-layout">
            <form:form
                    action="${pageContext.request.contextPath}/admin/product/save-product?${_csrf.parameterName}=${_csrf.token}"
                    method="post" modelAttribute="product" enctype="multipart/form-data" class="form-horizontal">
                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="productName" cssStyle="color: #ff0000"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productName">Product Name :</label>
                    <div class="col-xs-9">
                        <form:input path="productName" class="form-control" placeholder="Enter Product Name"
                                    id="productName"/>
                    </div>
                </div>


                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="productBrand" cssStyle="color: #ff0000"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productBrand">Product Brand :</label>
                    <div class="col-xs-9">
                        <form:input path="productBrand" class="form-control" placeholder="Enter Product Brand"
                                    id="productBrand"/>
                    </div>
                </div>


                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="productModel" cssStyle="color: #ff0000"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productModel">Product Model :</label>
                    <div class="col-xs-9">
                        <form:input path="productModel" class="form-control" placeholder="Enter Product model"
                                    id="productModel"/>
                    </div>
                </div>


                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="productPrice" cssStyle="color: #ff0000"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productPrice">Product Price :</label>
                    <div class="col-xs-9">
                        <form:input path="productPrice" class="form-control" placeholder="Enter Product Price"
                                    id="productPrice"/>
                    </div>
                </div>


                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="unitInStock" cssStyle="color: #ff0000"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="unitInStock">Product Stock :</label>
                    <div class="col-xs-9">
                        <form:input path="unitInStock" class="form-control" placeholder="Enter Product Unit in Stock"
                                    id="unitInStock"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productStatus">Product Status :</label>
                    <div class="col-xs-9">
                        <label class="checkbox-inline">
                            <form:radiobutton path="productStatus" id="productStatus" value="Brand New"/>
                            Brand New
                        </label>
                        <label class="checkbox-inline">
                            <form:radiobutton path="productStatus" id="productStatus" value="Old"/>
                            Old
                        </label>
                    </div>
                </div>


                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="productCategory" cssStyle="color: #ff0000"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productCategory">Product Category :</label>
                    <div class="col-xs-9">
                        <form:select path="productCategory">
                            <form:option value="NONE" label="--- Select ---"/>
                            <form:options items="${product.categoryList}"/>
                        </form:select>
                    </div>
                </div>


                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="productDescription" cssStyle="color: #ff0000"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productDescription">Product Description :</label>
                    <div class="col-xs-9">
                        <form:input path="productDescription" class="form-control"
                                    placeholder="Enter Product Description" id="productDescription"/>
                    </div>
                </div>


                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="discount" cssStyle="color: #ff0000"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="discount">Product Discount(%):</label>
                    <div class="col-xs-9">
                        <form:input path="discount" class="form-control" placeholder="Enter Product Discount"
                                    id="discount"/>
                    </div>
                </div>

                <c:if test="${not empty update}">
                    <div class="form-group has-success">
                        <label class="col-xs-3 control-label" for="productImage">product Picture :</label>
                        <div class="col-xs-9">
                            <img style="width:50%" alt="image" src="/product/rest/get-img/${productID}"/>
                        </div>
                    </div>
                </c:if>

                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productImage">Upload Picture :</label>
                    <div class="col-xs-9">
                        <form:input path="productImg" id="productImage" type="file" class="form:input-large"/>
                    </div>
                </div>


                <%--                <div class="form-group has-success">--%>
                <%--                    <label class="col-xs-3 control-label" for="productImage">Upload Picture :</label>--%>
                <%--                    <div class="col-xs-9">--%>
                <%--                        <form:input path="productImg" id="productImage" type="file" class="form:input-large"/>--%>
                <%--                    </div>--%>
                <%--                </div>--%>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <c:choose>
                            <c:when test="${not empty update}">
                                <input type="submit" value="update" class="btn btn-default/">
                                <input type="hidden" name="productID" value="${productID}" hidden/>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="Submit" class="btn btn-default"/>
                            </c:otherwise>
                        </c:choose>
                        <a href="<c:url value="/admin/product-management/1" />" class="btn btn-default">Cancel</a>
                    </div>
                </div>


            </form:form>
        </div>

    </div>

</div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>