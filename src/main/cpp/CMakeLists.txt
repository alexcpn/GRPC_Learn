cmake_minimum_required(VERSION 3.3)
project(TestGrpc)
find_package(Protobuf REQUIRED)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(PROTO_FILE_NAME simple_rpc)
set(PROTO_PATH ${CMAKE_SOURCE_DIR})
get_filename_component(PROTO_PATH ${PROTO_PATH} DIRECTORY)
get_filename_component(PROTO_PATH ${PROTO_PATH} DIRECTORY)
set(GENERATED_PROTOBUF_PATH ${CMAKE_SOURCE_DIR}/generated)

execute_process(COMMAND  which grpc_cpp_plugin OUTPUT_VARIABLE GRPC_CPP_PLUGIN)
string(STRIP ${GRPC_CPP_PLUGIN} GRPC_CPP_PLUGIN)
message(STATUS "MY_VAR=${GRPC_CPP_PLUGIN}")
file(MAKE_DIRECTORY ${GENERATED_PROTOBUF_PATH})

add_custom_command(
    OUTPUT  "${PROTO_FILE_NAME}.pb.cc"
            "${PROTO_FILE_NAME}.pb.h"
            "${PROTO_FILE_NAME}.grpc.pb.h"
            "${PROTO_FILE_NAME}.grpc.pb.cc"
    COMMAND ${PROTOBUF_PROTOC_EXECUTABLE}
    ARGS "--proto_path=${PROTO_PATH}"
    "--cpp_out=${GENERATED_PROTOBUF_PATH}"
    "${PROTO_PATH}/${PROTO_FILE_NAME}.proto"
    COMMAND ${PROTOBUF_PROTOC_EXECUTABLE}
    ARGS "--proto_path=${PROTO_PATH}"
    "--grpc_out=${GENERATED_PROTOBUF_PATH}"
    "--plugin=protoc-gen-grpc=${GRPC_CPP_PLUGIN}"
    "${PROTO_PATH}/${PROTO_FILE_NAME}.proto"
  )

   
add_custom_target(run ALL
    DEPENDS "${PROTO_FILE_NAME}.grpc.pb.h")    

set(OUT_FILES
		"${PROTO_FILE_NAME}.pb.cc"
            "${PROTO_FILE_NAME}.pb.h"
            "${PROTO_FILE_NAME}.grpc.pb.h"
            "${PROTO_FILE_NAME}.grpc.pb.cc")

set (GENERATED_PROTOBUF_FILES
            "${GENERATED_PROTOBUF_PATH}/${PROTO_FILE_NAME}.pb.cc"
            "${GENERATED_PROTOBUF_PATH}/${PROTO_FILE_NAME}.pb.h"
            "${GENERATED_PROTOBUF_PATH}/${PROTO_FILE_NAME}.grpc.pb.h"
            "${GENERATED_PROTOBUF_PATH}/${PROTO_FILE_NAME}.grpc.pb.cc"
)
add_custom_target(vsphere_header ALL  DEPENDS ${OUT_FILES})  #Targer name curtsey SO

set_source_files_properties(${GENERATED_PROTOBUF_FILES}
                            PROPERTIES GENERATED TRUE)
							
include_directories(/usr/local/include)
link_directories(/usr/local/lib)
include_directories(${GENERATED_PROTOBUF_PATH})
include_directories(${Protobuf_INCLUDE})
link_libraries(grpc++_unsecure grpc ${PROTOBUF_LIBRARY})

add_executable(TestGrpcServer simple_server.cpp ${GENERATED_PROTOBUF_FILES})
add_executable(TestGrpcClient simple_client.cpp ${GENERATED_PROTOBUF_FILES})

add_dependencies(TestGrpcServer vsphere_header)
add_dependencies(TestGrpcClient vsphere_header)
