cmake_minimum_required(VERSION 3.22.1)
project("base")


find_library(log-lib log)

add_library(Elysia SHARED Elysia.cpp)

target_link_libraries(Elysia ${log-lib})