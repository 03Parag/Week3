package Week3.Day01;

// SocialMediaFriendConnections class
class SocialMediaFriendConnections {

    // Node class representing a user
    class User {
        // Attributes for user node
        int userId;
        String name;
        int age;
        // Linked list for friends
        FriendNode friendsHead;
        User next;

        // Constructor for a user node
        public User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendsHead = null;
            this.next = null;
        }

        // Add a friend connection
        public void addFriend(int friendId) {
            FriendNode newFriend = new FriendNode(friendId);
            if (friendsHead == null) {
                friendsHead = newFriend;
            } else {
                FriendNode current = friendsHead;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newFriend;
            }
        }

        // Remove a friend connection
        public void removeFriend(int friendId) {
            if (friendsHead == null) return;

            // If the head is the friend to be removed
            if (friendsHead.friendId == friendId) {
                friendsHead = friendsHead.next;
                return;
            }

            FriendNode current = friendsHead;
            while (current.next != null && current.next.friendId != friendId) {
                current = current.next;
            }

            if (current.next != null) {
                // Remove the friend
                current.next = current.next.next;
            }
        }

        // Find mutual friends between this user and another user
        public void findMutualFriends(User otherUser) {
            FriendNode current = this.friendsHead;
            System.out.println("Mutual friends between " + this.name + " and " + otherUser.name + ":");
            boolean found = false;
            while (current != null) {
                FriendNode otherCurrent = otherUser.friendsHead;
                while (otherCurrent != null) {
                    if (current.friendId == otherCurrent.friendId) {
                        System.out.println("Friend ID: " + current.friendId);
                        found = true;
                        break;
                    }
                    otherCurrent = otherCurrent.next;
                }
                current = current.next;
            }

            if (!found) {
                System.out.println("No mutual friends.");
            }
        }

        // Display all friends of this user
        public void displayFriends() {
            if (friendsHead == null) {
                System.out.println("No friends yet.");
                return;
            }

            FriendNode current = friendsHead;
            System.out.println("Friends of " + this.name + ":");
            while (current != null) {
                System.out.println("Friend ID: " + current.friendId);
                current = current.next;
            }
        }
    }

    // Node class representing a friend's ID (Singly Linked List for friends)
    class FriendNode {
        // Attributes for friend node
        int friendId;
        FriendNode next;

        // Constructor for a friend node
        public FriendNode(int friendId) {
            this.friendId = friendId;
            this.next = null;
        }
    }

    // Head pointer for the singly linked list of users
    private User head = null;

    // Add a new user to the system
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
        System.out.println("User added: " + name + " (ID: " + userId + ")");
    }

    // Search for a user by User ID
    public User searchUser(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);

        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
            System.out.println("Friend connection added between User ID " + userId1 + " and User ID " + userId2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
            System.out.println("Friend connection removed between User ID " + userId1 + " and User ID " + userId2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);

        if (user1 != null && user2 != null) {
            user1.findMutualFriends(user2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayAllFriends(int userId) {
        User user = searchUser(userId);
        if (user != null) {
            user.displayFriends();
        } else {
            System.out.println("User ID " + userId + " not found.");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        User current = head;
        while (current != null) {
            int count = 0;
            FriendNode friendCurrent = current.friendsHead;
            while (friendCurrent != null) {
                count++;
                friendCurrent = friendCurrent.next;
            }
            System.out.println("User ID " + current.userId + " (" + current.name + ") has " + count + " friends.");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaFriendConnections socialMediaSystem = new SocialMediaFriendConnections();

        // Add users to the system
        socialMediaSystem.addUser(1, "Alice", 25);
        socialMediaSystem.addUser(2, "Bob", 30);
        socialMediaSystem.addUser(3, "Charlie", 28);
        socialMediaSystem.addUser(4, "David", 22);

        // Add friend connections
        socialMediaSystem.addFriendConnection(1, 2);
        socialMediaSystem.addFriendConnection(2, 3);
        socialMediaSystem.addFriendConnection(1, 3);

        // Display all friends of a specific user
        socialMediaSystem.displayAllFriends(1);

        // Find mutual friends between two users
        socialMediaSystem.findMutualFriends(1, 2);

        // Remove a friend connection
        socialMediaSystem.removeFriendConnection(1, 3);

        // Display all friends after removal
        socialMediaSystem.displayAllFriends(1);

        // Count the number of friends for each user
        socialMediaSystem.countFriends();
    }
}


