//
// Created by alex on 3/9/17.
//

#include <grpc++/grpc++.h>
#include "simple_rpc.grpc.pb.h"

using namespace grpc;
using namespace std;
using namespace simpleservice;

class SimpleClient{

public:
     SimpleClient(shared_ptr<Channel> channel):
             stub_(SimpleService::NewStub(channel)){}

    string getDataFromServer(string inputdata){

        InputMessage in_message;
        OutputMessage out_message;

        in_message.set_in_message(inputdata);
        ClientContext context;
        Status status = stub_->getData(&context,in_message,&out_message);
        if (status.ok()) {
            return out_message.out_message();
        } else {
            return "RPC failed";
        }

    }

    std::unique_ptr<SimpleService::Stub> stub_;
};


int main(int argc, char** argv) {
    // Instantiate the client.

    SimpleClient client(grpc::CreateChannel("localhost:50051", grpc::InsecureChannelCredentials()));
    std::string user("world");
    std::string reply = client.getDataFromServer("from the Other Side");
    std::cout << "Client received: " << reply << std::endl;

    return 0;
}