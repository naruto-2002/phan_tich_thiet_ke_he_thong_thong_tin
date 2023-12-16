const selectShipper = document.getElementById("select-shipper");
const deliveryDate = document.getElementById("delivery-date");

function saveHandle(e, hdmId, nvkId) {
    e.preventDefault();
    nvghId = selectShipper.value;
    ngayGiao = deliveryDate.value;

    window.location.href = `/DE_9_QLSTDM_war/xac-nhan-duyet-don?hdmId=${hdmId}&nvkId=${nvkId}&nvghId=${nvghId}&ngayGiao=${ngayGiao}`;

}

function closeHandle(e) {
    e.preventDefault();
    window.location.href = "/DE_9_QLSTDM_war/danh-sach-hoa-don-mua";
}