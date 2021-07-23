function modal(id) {
    var zIndex = 9999;
    var modal = document.getElementById(id);

    var bg = document.createElement('div');
    bg.setStyle({
        positon: 'fixed',
        zIndex: zIndex,
        left: '0px',
        top: '0px',
        width: '100%',
        height: '100%',
        overflow: 'auto',
        backgroundColor: 'rgba(128,128,128,0.4)'
    });
    document.body.append(bg);

    modal.querySelector('modal_close').addEventListener('click', function() {
        bg.remove();
        modal.style.display = 'none';
    });

    modal.setStyle({
        position: 'fixed',
        display: 'block',
        boxShadow: '0 4ps 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgab(0, 0, 0, 0.19)',

        zIndex: zIndex + 1,

        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        msTransform: 'translate(-50%, -50%)',
        webkitTransform: 'translate(-50%, -50%)'
    });

    document.getElementById('modal_open').addEventListener('click', function() {
        modal('modal_area');
    })


}

