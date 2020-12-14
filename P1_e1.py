import numpy as np
from matplotlib import cm
import matplotlib.pyplot as plt
from random import random, seed
from mpl_toolkits.mplot3d import Axes3D
from matplotlib.ticker import LinearLocator, FormatStrFormatter
from sklearn.preprocessing import PolynomialFeatures
from sklearn.linear_model import Ridge, LinearRegression, Lasso, Ridge
from sklearn.model_selection import cross_validate

fig = plt.figure()
ax = fig.gca(projection = "3d")

# Make data.
x = np.arange(0, 5, 0.31)
y = np.arange(0, 5, 0.3)
x, y = np.meshgrid(x, y)

def FrankeFunction(x,y):
    term1 = 0.75 * np.exp(-(0.25 * (9 * x - 2) ** 2) - 0.25 * ((9 * y - 2) ** 2))
    term2 = 0.75 * np.exp(-((9 * x + 1) ** 2) / 49.0 - 0.1 * (9 * y + 1))
    term3 = 0.5 * np.exp(-(9 * x - 7) ** 2 / 4.0 - 0.25 * ((9 * y - 3) ** 2))
    term4 = -0.2 * np.exp(-(9 * x - 4) ** 2 - (9 * y - 7) ** 2)
    return term1 + term2 + term3 + term4

z = FrankeFunction(x, y)

def PlaneLineReg(x, y, z):
    X = np.zeros((len(z), 11))
    X[:, 0] = 1
    X[:, 1] = x[0]
    X[:, 2] = y[:, 0]
    X[:, 3] = x[0] ** 2
    X[:, 4] = y[:, 0] ** 2
    X[:, 5] = x[0] ** 3
    X[:, 6] = y[:, 0] ** 3
    X[:, 7] = x[0] ** 4
    X[:, 8] = y[:, 0] ** 4
    X[:, 9] = x[0] ** 5
    X[:, 10] = y[:, 0] ** 5

    beta = np.linalg.inv(X.T.dot(X)).dot(X.T).dot(z)

    y_pred = X @ beta

    return beta, y_pred

params, pred = PlaneLineReg(x, y, z)

"""
# Plot the surface.
surf = ax.plot_surface(x, y, z, cmap = cm.coolwarm,
linewidth = 0, antialiased = False)

# Customize the z axis.
ax.set_zlim(-0.10, 1.40)
ax.zaxis.set_major_locator(LinearLocator(10))
ax.zaxis.set_major_formatter(FormatStrFormatter("%.02f"))

# Add a color bar which maps values to colors.
fig.colorbar(surf, shrink = 0.5, aspect = 5)
plt.show()
"""


"""
np.random.seed(4155)

### a)

# Generate the data
nrow = 100
ncol = 200
ax_row = np.random.uniform(0, 1, size=nrow)
ax_col = np.random.uniform(0, 1, size=ncol)

ind_sort_row = np.argsort(ax_row)
ind_sort_col = np.argsort(ax_col)

ax_row_sorted = ax_row[ind_sort_row]
ax_col_sorted = ax_col[ind_sort_col]

colmat, rowmat = np.meshgrid(ax_col_sorted, ax_row_sorted)

noise_str = .0
noise = np.random.randn(nrow, ncol)

z = FrankeFunction(rowmat, colmat) + noise_str * noise

row_arr = rowmat.ravel()
col_arr = colmat.ravel()
z_arr = z.ravel()

# Generate the design matrix
p = 10
poly = PolynomialFeatures(degree = p)
X = poly.fit_transform(np.c_[row_arr, col_arr])

## Perform OLS
linreg = LinearRegression()
linreg.fit(X, z_arr)

zpred = linreg.predict(X)
zplot = zpred.reshape(nrow, ncol)
"""
# Plot the resulting fit beside the original surface
fig = plt.figure()

ax = fig.add_subplot(1, 2, 1, projection='3d')
surf = ax.plot_surface(x, y, z, cmap=cm.viridis, linewidth=0, antialiased=False)
fig.colorbar(surf, shrink=0.5, aspect=5)
plt.title('Franke')

ax = fig.add_subplot(1, 2, 2, projection='3d')
surf = ax.plot_surface(x, y, pred, cmap=cm.viridis, linewidth=0, antialiased=False)
fig.colorbar(surf, shrink=0.5, aspect=5)
plt.title('Fitted Franke')

plt.show()
#"""