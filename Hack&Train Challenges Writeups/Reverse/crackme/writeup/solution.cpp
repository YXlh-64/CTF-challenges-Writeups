#include <iostream>
#include <math.h>

using namespace std;

int main()
{

    // defining the result array (an array of shorts)
    short result[25] = {0x1aee, 0x27de, 0x264e, 0x1086, 0x14d6,
                        0x3b1e, 0x2976, 0x0905, 0x0905, 0x2715, 
                        0x2346, 0x2d95, 0x357e, 0x264e, 0x2cbe, 
                        0x2346, 0x2a45, 0x0a95, 0x264e, 0x2cbe,
                        0x0a2e, 0x32c9, 0x33ae, 0x0446, 0x3d0e };

    // defining the transformed version of the flag
    int flag_1[25]; //notice that the last character must be a null terminator, thus the flag length is 24
    for (int i = 0; i < 25; ++i)
    {
        flag_1[i] = result[i];
    }
    char flag[25] = {};
    for (int i = 0; i < 25; ++i)
    {
        int temp = sqrt(flag_1[i] - 5);
        flag[i] = (char)temp;
    }

    cout << "The flag is " << flag << endl;

    return 0;
}