#include <stdexcept>
#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

std::pair<int, int> findTwoSum(const std::vector<int>& list, int sum)
{
    //throw std::logic_error("Waiting to be implemented");
    sort(list.begin(),list.end());

    int i = 0; int j = list.size() - 1;
    int idx1 = 0, idx2 = 0;
    while (i < j) {
        if (list[i] + list[j] == 10) {
            idx1 = i;
            idx2 = j;
            break;
        }
        if (list[i] + list[j] < 10) i++;
        if (list[i] + list[j] > 10)j++;
    }
    return { idx1,idx2 };
}

#ifndef RunTests
int main()
{
    std::vector<int> list = { 3, 1, 5, 7, 5, 9 };
    std::pair<int, int> indices = findTwoSum(list, 10);
    std::cout << indices.first << '\n' << indices.second;
}
#endif
