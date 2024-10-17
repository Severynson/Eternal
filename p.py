# for i in range(1,48):
#     print("I", end=f"{"\n" if i % 10 == 0 else "" }")

import numpy as np

o = np.array([48, 40, 18, 9])
e = np.array([28.75, 28.75, 28.75, 28.75])

result = ((o - e) ** 2) / e
print(sum(result))