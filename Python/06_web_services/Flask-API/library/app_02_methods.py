from flask import Flask, jsonify, request, abort, make_response

app = Flask(__name__)


# lista de coisas ... mais tarde obter os dados da base de dados
things = [
    {
        'id': 1,
        'name': 'Prometheus',
        'local': '@lab. 163 / ISE /UAlg',
        'sensors': [
            {'sensor_name': 'mem_sensor', 'units': 'percent'},
            {'sensor_name': 'cpu_sensor', 'units': 'percent'}
        ]
    },
    {
        'id': 2,
        'name': 'Zeus',
        'local': '@lab. 163 / ISE /UAlg',
        'sensors': [
            {'sensor_name': 'temperature', 'units': 'numerical'},
            {'sensor_name': 'humidity', 'units': 'percent'}
        ]
    }
]

things_counter = 2


# função para manipular erros por código ou classe de exceção.
@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'Erro': 'Não encontrada'}), 404)


@app.route('/iot/api/v1.0/things/', methods=['GET'])
def get_things():
    return jsonify({'things': things})


@app.route('/iot/api/v1.0/things/<int:thing_id>', methods=['GET'])
def get_thing(thing_id):

    for thing in things:
        if thing['id'] == thing_id:
            break
    else:
        abort(404)

    return jsonify({'thing': thing})


@app.route('/iot/api/v1.0/things/', methods=['POST'])
def create_thing():
    # When the When the Flask application handles a request, it creates a Request object based on the environment it
    # received from the WSGI server. Because a worker (thread, process, or coroutine depending on the server) handles
    # only one request at a time, the request data can be considered global to that worker during that request.

    # request.json terá os dados da solicitação, mas somente se vierem marcados como JSON.
    if not request.json or 'name' not in request.json or 'local' not in request.json or 'sensors' not in request.json:
        # See https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
        # 400 Bad Request - The server could not understand the request due to invalid syntax.
        abort(400)

    global things_counter
    things_counter += 1
    thing = {
        'id': things_counter,
        'name': request.json['name'],
        'local': request.json['local'],
        'sensors': request.json['sensors']
    }
    things.append(thing)
    # status code 201, which HTTP defines as the code for "Created". See https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
    # a resposta de um POST deve ter o suficiente para saber duas coisas:
    # - Que a criação aconteceu(código 201)
    # - Onde encontrar a coisa nova (neste caso bastaria devolver o novo id)
    return jsonify(thing), 201


@app.route('/iot/api/v1.0/things/<int:thing_id>', methods=['PUT'])
def update_thing(thing_id):

    for thing in things:
        if thing['id'] == thing_id:
            break
    else:
        abort(404)

    if not request.json:
        abort(400) # 400 Bad Request

    thing['name'] = request.json.get('name', thing['name'])
    thing['local'] = request.json.get('local', thing['local'])
    thing['sensors'] = request.json.get('sensors', thing['sensors'])

    return jsonify({'thing': thing})


@app.route('/iot/api/v1.0/things/<int:thing_id>', methods=['DELETE'])
def delete_thing(thing_id):
    for thing in things:
        if thing['id'] == thing_id:
            break
    else:
        abort(404)

    things.remove(thing)

    return jsonify({'result': True})


if __name__ == '__main__':
    app.run(debug=True)
