import request from '@/utils/request'

// 查询二维码列表
export function listQrcode(query) {
  return request({
    url: '/awise/qrcode/list',
    method: 'get',
    params: query
  })
}

// 获取工序对应二维码
export function getQrCode(query){
  return request({
    url: '/awise/qrcode/get',
    method: "get",
    params: query
  })
}

// 新增二维码
export function addQrcode(data) {
  return request({
    url: '/awise/qrcode',
    method: 'post',
    data: data
  })
}

// 修改二维码
export function updateQrcode(data) {
  return request({
    url: '/awise/qrcode',
    method: 'put',
    data: data
  })
}

// 删除二维码
export function delQrcode(id) {
  return request({
    url: '/awise/qrcode/' + id,
    method: 'delete'
  })
}
