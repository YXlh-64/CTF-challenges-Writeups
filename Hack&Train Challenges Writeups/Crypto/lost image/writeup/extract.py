from PIL import Image

# Open the image
image = Image.open("out.png")

# Get the height and the width for the image
WIDTH, HEIGHT= image.size

#load the pixels of the image into a matrix
pixels = image.load()


def extract(pixels):
    binary_flag=""

    #extracting the lsb from the blue channel from the pixels of the image
    for i in range (image.width):
        for j in range (image.height):
            pixel = pixels[i, j] #get the specific pixel from the image

            # Retrieve the blue channel value
            blue_channel = pixel[2] #the third channel

            # Convert the blue channel value to binary and extract the LSB then Extract the LSB by indexing from the end
            blue_channel_LSB = bin(blue_channel)[-1]  

            # Append the LSB to binary_flag
            binary_flag += blue_channel_LSB

    return binary_flag


binary_flag = extract(pixels)
print(len(binary_flag))

#to obtain the ASCII representation of the flag
n = int(binary_flag, 2)
print(n.to_bytes((n.bit_length() + 7) // 8, 'big').decode())