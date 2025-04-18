package lk.ijse.helloshoe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {
    private String itemCode;
    @NotBlank(message = "Item Description can not be null")
    @Pattern(regexp = "[A-Za-z ]+", message = "Item Description is not valid")
    private String itemDesc;
    private String  itemPic;
    @NotBlank(message = "Category can not be null")
    private String category;
    @NotBlank(message = "Category can not be null")
    @Positive(message = "Size must be a positive integer value")
    private int size;
    @NotBlank(message = "Supplier Code can not be null")
    private String supplierCode;
    @NotBlank(message = "Supplier Name can not be null")
    private String supplierName;
    @NotBlank(message = "Unit price can not be null")
    @Positive(message = "Unit price must be a positive value")
    private double unitPriceBuy;
    @NotBlank(message = "Unit price can not be null")
    @Positive(message = "Unit price must be a positive value")
    private double unitPriceSale;
    @NotBlank(message = "Quantity can not be null")
    @Positive(message = "Quantity must be a positive integer value")
    private int quantity;
    @NotBlank(message = "Profit can not be null")
    @Positive(message = "Profit must be a positive value")
    private double profit;
    @NotBlank(message = "Profit can not be null")
    private double profitMargin;
    @NotBlank(message = "Status can not be null")
    private Snippet.Status status;
}


