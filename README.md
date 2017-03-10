# GRPC_Learn

A simple GRPC Server and Client in different languages -Scala and CPP and Python (will add that later) for demonstration.
If you are interested in CPP with CMake, then the CPP sample may be interseting to you as the regular samples are using make.

If you are running in Ubuntu , make sure you compile build and install protoc(1) to the latest (support of proto3 syntax) along with the grpc C++ plugin. This is necessary to develop server and client in c++

For Ubuntu 16.04

protoc has to be updated from the default 2.4  Else you will get protoc give error that proto 3 is not recoganised
https://github.com/google/protobuf/tree/master/src (need to make it)
 
In case you face error in building ( download gzip) above see https://github.com/grpc/grpc/issues/7952
 
