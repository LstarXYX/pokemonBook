import service from '../axios'

export function requestLogin(data) {
    return service({
        method: 'post',
        url: "/admin/login",
        data: JSON.stringify(data)
    })
}