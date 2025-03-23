def call(Map params) {
    // Access parameters
    def name = params.name ?: "Guest"
    def age = params.age ?: 18

    echo "Hello, ${name}! You are ${age} years old."
}
