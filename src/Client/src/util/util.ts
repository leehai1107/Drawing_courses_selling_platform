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

  export {numberToVietnameseDong}