#include <stdlib.h>
#include <string>
#include <sys/types.h>
#include <sys/socket.h>
//#include <netinet/in>


#define PORT 8080

int main(int argc, char** argv){
    int server_fd, new_socket, valread;
    struct sockaddr_in address;
    int opt = 1;
    int addrlen = sizeof(address);
    char buffer[1024] = {0};
    char *hello = "Hello from server\n";

    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0){
        perror("socket failed\n");
        exit(EXIT_FAILURE);
    }
}