#include <tuple>
#include <stdexcept>
#include <iostream>
#include <string>
#include <cmath>
#include <cstdlib>

std::pair<double, double> findRoots(double a, double b, double c)
{
    //throw std::logic_error("Waiting to be implemented");

    double x = pow(b,2) - (4 * a * c);
    double square = sqrt(x);
    double numerator1 = square - b;
    double numerator2 = -square - b;
    double first = numerator1 /(2*a);
    double second = numerator2 / (2*a);
    return std::make_pair(first, second);

}

#ifndef RunTests
int main()
{
    std::pair<double, double> roots = findRoots(1, 1, 0);
    std::cout << "Roots: " + std::to_string(roots.first) + ", " + std::to_string(roots.second);
}
#endif
