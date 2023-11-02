import { atom } from "recoil";

export const accountState = atom({
    key: "acount",
    default: undefined
})

export const cartState = atom({
    key: "cart",
    default: []
})