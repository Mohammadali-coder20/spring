<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Shipping Address & Billing Address Page</h1>

            <p class="lead">Here is address of ${customerAddress.userName}</p>
        </div>
    
      <h1>Shipping Address</h1>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Street Name</th>
                <th>Apartment Number</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>ZipCode</th>
                
            </tr>
            </thead>
            
                <tr>
                    <td>${customerAddress.shippingAddress.streetName}</td>
                    <td>${customerAddress.shippingAddress.apartmentNumber}</td>
                    <td>${customerAddress.shippingAddress.city}</td>
                    <td>${customerAddress.shippingAddress.state}</td>
                    <td>${customerAddress.shippingAddress.country}</td>
                    <td>${customerAddress.shippingAddress.zipCode}</td>
                </tr>
           
        </table>
        
        
        
        
        
        
        <h1>Billing Address</h1>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Strret Name</th>
                <th>Apartment Number</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>ZipCode</th>
                
            </tr>
            </thead>
            
                <tr>
                    <td>${customerAddress.billingAddress.streetName}</td>
                    <td>${customerAddress.billingAddress.apartmentNumber}</td>
                    <td>${customerAddress.billingAddress.city}</td>
                    <td>${customerAddress.billingAddress.state}</td>
                    <td>${customerAddress.billingAddress.country}</td>
                    <td>${customerAddress.billingAddress.zipCode}</td>
                </tr>
           
        </table>

        

<%@ include file="/WEB-INF/views/template/footer.jsp" %>