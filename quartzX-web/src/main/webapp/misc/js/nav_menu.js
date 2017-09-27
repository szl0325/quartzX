$(function() {
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		// Variables privadas
		var links = this.el.find('.link');
		// Evento
		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
			$this = $(this),
			$next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
		};
	}

	var accordion = new Accordion($('#accordion'), false);

	/*面包屑*/
	$(".submenu a").click(function () {
        var pName = $(".accordion li.open .link").text();
        var name = $(this).text();
        var a = '<li>Home</li><li>'+pName+'</li><li class="active">'+name+'</li>';
        $(".breadcrumb").html(a);
    });
});