from pwn import xor 

magic = bytes.fromhex('89504E470D0A1A0A')
lost = open('../lost.png' , 'rb').read()

key = xor(magic , lost[:len(magic)])
flag = xor(lost , key)
open('out.png' , 'wb').write(flag)