$(function() {
	var loading = false;
	var maxItems = 999;
	var pageSize = 10;
	var listUrl = '/myo2o/frontend/listawardsbyshop';
	var pageNum = 1;
	var parentId = getQueryString('parentId');
	var enableStatus = getQueryString('enableStatus');
	var areaId = '';
	var shopCategoryId = '';
	var shopName = '';
	var addUserAwardMap = '/myo2o/frontend/adduserawardmap'

	function addItems(pageSize, pageIndex) {
		// 生成新条目的HTML
		var url = listUrl + '?enableStatus='+ enableStatus + '&pageIndex=' + pageIndex + '&pageSize='
				+ pageSize;
		loading = true;
		$.getJSON(url, function(data) {
			if (data.success) {
				maxItems = data.count;
				var html = '';
				data.awardList.map(function(item, index) {
					html += '' + '<div class="card" data-award-id="'
							+ item.awardId + '">' + '<div class="card-header">'
							+ item.awardName + '</div>'
							+ '<div class="card-content">'
							+ '<div class="list-block media-list">' + '<ul>'
							+ '<li class="item-content">'
							+ '<div class="item-media">' + '<img src="'
							+ getContextPath() +item.awardImg + '" width="44">' + '</div>'
							+ '<div class="item-inner">'
							+ '<div class="item-subtitle">' + item.awardDesc
							+ '</div>' 
							+ '<div class="item-subtitle">' + '兑换积分' +item.point
							+ '</div>' + '</div>' + '</li>' + '</ul>'
							+ '</div>' + '</div>' + '<div class="card-footer">'
							+ '<p class="color-gray">'
							+ new Date(item.lastEditTime).Format("yyyy-MM-dd")
							+ '更新</p>' + '<span>兑换</span>' + '</div>'
							+ '</div>';
				});
				$('.list-div').append(html);
				var total = $('.list-div .card').length;
				if (total >= maxItems) {
					// 加载完毕，则注销无限加载事件，以防不必要的加载
					//$.detachInfiniteScroll($('.infinite-scroll'));
					// 隐藏加载提示符
					$('.infinite-scroll-preloader').hide();
				}else{
					$('.infinite-scroll-preloader').show();
				}
				pageNum += 1;
				loading = false;
				$.refreshScroller();
			}
		});
	}
	// 预先加载20条
	addItems(pageSize, pageNum);

	$(document).on('infinite', '.infinite-scroll-bottom', function() {
		if (loading)
			return;
		addItems(pageSize, pageNum);
	});

	$('.shop-list').on('click', '.card', function(e) {
		var awardId = e.currentTarget.dataset.awardId;
		var formData = new FormData();
		formData.append('awardId', awardId);
				$.ajax({
			url : addUserAwardMap,
			type : 'POST',
			data : formData,
			//contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					$.toast('兑换成功！');
				} else {
					$.toast('兑换失败！');
					$('#captcha_img').click();
				}
				$('#captcha_img').click();
			}
		});
	});

	$.init();
});
