
function approveBill(hdmId, nvkId) {
    window.location.href = `/DE_9_QLSTDM_war/trang-duyet-don?hdmId=${hdmId}&nvkId=${nvkId}`;
}

function detailBill(hdmId) {
    window.location.href = `/DE_9_QLSTDM_war/chi-tiet-hoa-don-mua?hdmId=${hdmId}`;
}