import React, { useState, useContext, useEffect } from "react";
import { View, Text, SafeAreaView, VirtualizedList, TouchableOpacity, Image } from "react-native";
import styles from "./style";
import { AuthContext } from "../../context/auth";
import blogFetch from "../../axios/config";

export default function Info() {
    const { idCadastro, nome } = useContext(AuthContext);
    const [idCarteira, setIdCarteira] = useState();
    const [dados, setDados] = useState();
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(false);

    

    async function getIdCarteira(){
        console.log();
        try {
            const response = await blogFetch.get(`/carteira-vacina/listar-id/${idCadastro}`);
            const data = (response.data);
            const carteira = data.id_carteiraVacina;
            setIdCarteira(carteira);
            getDados();
            console.log(data);
        } catch (error) {
            const cadastro = "idCadastro";
            const formData = new FormData();
            formData.append('id_cadastro', cadastro);
            //formData.append('foto', null);
            await blogFetch.post("/carteira-vacina/cadastrar", formData);
            getIdCarteira();
            console.log(error, formData);
        }
    }

    async function getDados(){
        try {
            const response = await blogFetch.get(`vacinas-tomadas/por-carteira/${idCadastro}`);
            setDados(response.data);
        } catch (error) {
            console.log(error);
            setError(true);
        } finally {
            setLoading(false);
        }
    }

    useEffect(() => {
        getDados();
    }, []);

    const getVacinas = (dados, index) => dados[index];
    const getVacinasCount = (dados) => dados.length;

    const vacinasTomadas = ({ item }) => (
        <View style={styles.divconteiner}>
            <View style={styles.DivdeBaixo}>
                <Text>Nome da vacina: {item.vacina} </Text>
                <Text>Quantidade de dose tomada: {item.doseTomadas} </Text>
                <Text>Data da vacinação: {item.dataVacinaTomda} </Text>
                <Text>Descrição da vacina: {item.descricao} </Text>
            </View>
        </View>
    );

    return (
        <View style={styles.Tela1}>
            <View style={styles.Tela}>

                <View style={styles.Divdecima}>
                    <View style={styles.nomeIdade}>
                        <Text style={styles.Txt}>nome: {nome} </Text>
                    </View>
                    <View style={styles.imgdePerfil}>
                        <Text>Imagem aqui!</Text>
                    </View>
                </View>
                <View style={styles.DivdoMeio}>
                <Text style={styles.textMeio}>
                    adic. foto
                </Text>
                </View>


                <SafeAreaView style={styles.vacinas}>
                    {loading ? (
                        <Text>Procurando informações das vacinas</Text>
                    ) : error ? (
                        <Text>Sem vacinas cadastradas</Text>
                    ) : (
                        <VirtualizedList
                            data={dados}
                            initialNumToRender={100}
                            renderItem={vacinasTomadas}
                            keyExtractor={(vacinas) => vacinas.id_listavacina.toString()}
                            getItem={getVacinas}
                            getItemCount={getVacinasCount}
                            />
                        )}
                </SafeAreaView> 

            </View>
        </View>
    )
}
