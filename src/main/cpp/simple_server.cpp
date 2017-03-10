

#include <grpc++/grpc++.h>
#include "simple_rpc.grpc.pb.h"

using namespace grpc;
using namespace std;
using namespace simpleservice;

class SimpleServer final : public SimpleService::Service {

    ::grpc::Status getData(::grpc::ServerContext* context, const InputMessage* request,
            OutputMessage* response){
        std::string prefix("Hello ");
        response->set_out_message(prefix + request->in_message());
        return Status::OK;

    }
    
};

void RunServer() {
    std::string server_address("0.0.0.0:50051");
    SimpleServer service;

    ServerBuilder builder;
    builder.AddListeningPort(server_address, grpc::InsecureServerCredentials());
    builder.RegisterService(&service);
    std::unique_ptr<Server> server(builder.BuildAndStart());
    std::cout << "Server listening on " << server_address << std::endl;
    server->Wait();
}

int main(int argc, char*argv[]){
    
    cout << "Hello GRPC C++" <<endl;
    RunServer();
    
} 