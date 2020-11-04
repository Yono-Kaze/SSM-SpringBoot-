$(function(){
	var shopId = getQueryString("shopId");
	var shopInfoUrl ='/myo2o/shop/getshopmanagementinfo?shopId=' + shopId;
	$.getJSON(shopInfoUrl,function(data){
		if(data.redirect){
			window.location.href = data.url;
		}else{
			if(data.shopId != undefined && data.shopId != null){
				shopId =data.shopId;
			}
			$('#shopedit')
			.attr('href','/myo2o/shop/shopedit?shopId=' + shopId);
			$('#productcategorymanage')
			.attr('href','/myo2o/shop/productcategorymanage?shopId=' + shopId);
			$('#shopauthmanage')
			.attr('href','/myo2o/shop/shopauthmanage?shopId=' + shopId);
			$('#productbuycheck')
			.attr('href','/myo2o/shop/productbuycheck?shopId=' + shopId);
			$('#usershopcheck')
			.attr('href','/myo2o/shop/usershopcheck?shopId=' + shopId);
		}
	});
});