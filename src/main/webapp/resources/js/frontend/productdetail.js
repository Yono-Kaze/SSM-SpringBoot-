$(function() {
	var productId = getQueryString('productId');
	var productUrl = '/myo2o/frontend/listproductdetailpageinfo?productId='
			+ productId;

	$
			.getJSON(
					productUrl,
					function(data) {
						if (data.success) {
							var product = data.product;
							$('#product-img').attr('src', getContextPath() + product.imgAddr);
							$('#product-time').text(
									new Date(product.lastEditTime)
											.Format("yyyy-MM-dd"));
							$('#product-name').text(product.productName);
							$('#product-desc').text(product.productDesc);
							$('#product-point').text(product.point);
							var imgListHtml = '';
							product.productImgList.map(function(item, index) {
								imgListHtml += '<div> <img src="'
										+ getContextPath() +item.imgAddr + '"/></div>';
							});
							// 生成购买商品的二维码供商家扫描
							imgListHtml += '<div> <img src="/myo2o/frontend/generateqrcode4product?productId='
									+ product.productId + '"/></div>';
							$('#imgList').html(imgListHtml);
						}
					});
	$('#me').click(function() {
		$.openPanel('#panel-left-demo');
	});
	$.init();
	
	$('#buy').click(function() {
		var buy =  '/myo2o/shop/adduserproductmap?productId=' + productId;
				$.ajax({
			url : buy,
			type : 'GET',
			//contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					$.toast('购买成功！');
				} else {
					$.toast('购买失败！');
					$('#captcha_img').click();
				}
				$('#captcha_img').click();
			}
		});
	});
});


