
export const setTitem = (name:string, item:any) => {
    sessionStorage.setItem(name, JSON.stringify(item));
}

export const getTitem = (name:string) => {
    const itemStr:any = sessionStorage.getItem(name);
    return JSON.parse(itemStr)
}