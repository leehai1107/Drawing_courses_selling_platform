import jwt_decode from 'jwt-decode';

function numberToVietnameseDong(number:number) {
    // Check if the input is a valid number
    if (isNaN(number)) {
      return "Invalid input";
    }
  
    // Format the number as Vietnamese Dong
    const formattedNumber = new Intl.NumberFormat("vi-VN", {
      style: "currency",
      currency: "VND",
      minimumFractionDigits: 0,
    }).format(number);
  
    return formattedNumber;
  }

 

export const decodeToken = (token:string) => {
  try {
    const decodedToken = jwt_decode(token);

    // The decoded token will be a JavaScript object containing user information
    console.log(decodedToken);
    return decodedToken
  } catch (error) {
    console.error("Error decoding token:", error);
  }
};

export function formatDateToYYYYMMDD(date:Date) {
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const day = String(date.getDate()).padStart(2, '0');
  
  return `${year}-${month}-${day}`;
}

export function generateShortUUID(characters: string) {
  let shortUUID = '';

  for (let i = 0; i < 8; i++) {
    const randomIndex = Math.floor(Math.random() * characters.length);
    shortUUID += characters.charAt(randomIndex);
  }

  return shortUUID;
}

export function isPhoneNumberValid(phoneNumber:string) {
  // Define a regular expression pattern for a typical phone number.
  // This pattern assumes a North American phone number format.
  const phonePattern = /^\(?\d{3}\)?[-.\s]?\d{3}[-.\s]?\d{4}$/;

  // Test the input phoneNumber against the pattern.
  return phonePattern.test(phoneNumber);
}

export function generateRandomPassword(length:number) {
  const charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Define the character set
  let password = "";

  for (let i = 0; i < length; i++) {
    const randomIndex = Math.floor(Math.random() * charset.length);
    password += charset.charAt(randomIndex);
  }

  return password;
}
export function getTotalInCart(cart:any){
  return cart.reduce((accumulator:number, currentValue:any) => accumulator + currentValue?.Course?.price, 0);
}

export {numberToVietnameseDong}