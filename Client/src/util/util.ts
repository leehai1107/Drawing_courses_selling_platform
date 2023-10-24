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

  while(shortUUID.length<10){
    const randomIndex = Math.floor(Math.random() * characters.length);
    const randomChar = characters.charAt(randomIndex);
    if (randomChar !== '-') {
      shortUUID += randomChar;
    }
  }

  return shortUUID;
}

export {numberToVietnameseDong}